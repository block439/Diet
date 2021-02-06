package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.MealSearchService;
import pl.jazapp.app.diet.meals.products.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@Named
@RequestScoped
public class EditMealController {

    @Inject
    ParameterRetriever parameterRetriever;
    @Inject
    MealEditService mealEditService;
    @Inject
    MealSearchService mealSearchService;
    @Inject
    ProductSearchService productSearchService;
    @Inject
    ProductEditService productEditService;

    private EditMealRequest mealRequest;

    public EditMealRequest mealRequest(){
        if(mealRequest == null){
            if(parameterRetriever.contains("mealId")){
                var mealId = parameterRetriever.getParameterAsLong("mealId");
                var mealEntity = mealEditService.getMealById(mealId);
                mealRequest = new EditMealRequest(mealEntity);
            }
            else
                mealRequest = new EditMealRequest();
        }
        return mealRequest;
    }

    public String save(){
        mealRequest.productEditService=productEditService;
        mealRequest.mealEditService = mealEditService;

        var meal = mealRequest.toMealEntity();

        mealEditService.saveMeal(meal);


        var productsList = new LinkedList<MealProductEntity>();
        var products = mealEditService.getMealById(meal.getId()).getProducts().iterator();

        for(int i = 0; i < 3;i++) {
            var mealProduct = new MealProductEntity();
            if (meal.getId() != null && !mealEditService.getMealById(meal.getId()).getProducts().isEmpty() && products.hasNext()) {
                    mealProduct.setId(products.next().getId());
            }
            mealProduct.setMeal(meal);
            switch(i){
                case 0:
                    mealProduct.setProduct(productEditService.getProductById(mealRequest.getProductId1()));
                    mealProduct.setAmount(mealRequest.getAmount1());
                    break;
                case 1:
                    mealProduct.setProduct(productEditService.getProductById(mealRequest.getProductId2()));
                    mealProduct.setAmount(mealRequest.getAmount2());
                    break;
                case 2:
                    mealProduct.setProduct(productEditService.getProductById(mealRequest.getProductId3()));
                    mealProduct.setAmount(mealRequest.getAmount3());
                    break;
                default: break;
            }

            productsList.add(mealProduct);
        }
        meal.getProducts().clear();
        meal.setProducts(productsList);



        mealEditService.saveMeal(meal);

        return "/diets/meals/list.xhtml?faces-redirect=true";
    }


    public List<MealEntity> getListOfAllMeals(){
        return mealSearchService.listOfAllMeals();
    }


    public List<ProductEntity> getListOfAllProducts(){return productSearchService.listOfAllProducts();}


}
