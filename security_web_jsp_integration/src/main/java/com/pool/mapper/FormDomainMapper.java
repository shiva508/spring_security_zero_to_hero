package com.pool.mapper;

import com.pool.form.FarmerForm;
import com.pool.model.Crop;
import com.pool.model.Former;
import com.pool.form.CropForm;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.DateToStringConverter;

public class FormDomainMapper {
	private MapperFactory formDomainMapperFactory = null;

	public FormDomainMapper(MapperFactory mapperFactory) {
		this.formDomainMapperFactory = mapperFactory;
		ConverterFactory converterFactory = formDomainMapperFactory.getConverterFactory();
		converterFactory.registerConverter(new DateToStringConverter("MM-dd-yyyy HH:mm:ss"));
		cropFormToCrop();
		farmerFormToFarmer();
		
		/*userFormToUser();
		addressFormToAddress();
		featureFormToFeature();
		rankingFormToRanking();
		productFormToProduct();*/
	}

	private void cropFormToCrop() {
		formDomainMapperFactory.classMap(CropForm.class, Crop.class)
		.field("cropId", "cropId")
		.field("cropName", "cropName")
		.field("cropType", "cropType")
		.byDefault().register();
		
	}

	private void farmerFormToFarmer() {
		formDomainMapperFactory.classMap(FarmerForm.class, Former.class)
		.field("formerId", "formerId")
		.field("formerName", "formerName")
		.field("phoneNumber", "phoneNumber")
		.field("village", "village")
		.field("mandal", "mandal")
		.field("district", "district")
		.field("phinCode", "phinCode")
		.fieldBToA("crops", "cropList")
		.byDefault().register();

	}

	/*public void productFormToProduct() {
		formDomainMapperFactory.classMap(ProductForm.class, Product.class)
		.field("productMame", "productMame")
				.fieldBToA("featurs", "featursList")
				.fieldBToA("ranking", "rankingList")
				.field("productId", "productId")
				.byDefault().register();
	}
*/
	/*public void rankingFormToRanking() {
		formDomainMapperFactory.classMap(RankingForm.class, Ranking.class).field("rankingId", "rankingId")
				.field("ranking", "ranking").byDefault().register();
	}*/

	/*public void featureFormToFeature() {
		formDomainMapperFactory.classMap(FeaturesForm.class, Features.class)
		.field("featureId", "featureId")
		.field("feature", "feature").byDefault().register();

	}*/

	/*public void userFormToUser() {
		formDomainMapperFactory.classMap(UserForm.class, Users.class).field("userId", "userId")
				.field("userName", "username").fieldBToA("address", "addressForm").byDefault().register();
	}*/

	/*public void addressFormToAddress() {
		formDomainMapperFactory.classMap(AddressForm.class, Address.class).field("addressId", "addressId")
				.field("villageName", "villageName").field("mandal", "mandal").field("distrct", "distrct").byDefault()
				.register();
	}*/
}
