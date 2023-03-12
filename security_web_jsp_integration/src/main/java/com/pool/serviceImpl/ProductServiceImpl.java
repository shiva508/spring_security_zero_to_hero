package com.pool.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.ProductRepository;
import com.pool.form.FeaturesForm;
import com.pool.form.ProductForm;
import com.pool.form.RankingForm;
import com.pool.form.RankingResponse;
import com.pool.model.Features;
import com.pool.model.Product;
import com.pool.model.Ranking;
import com.pool.service.ProductService;

import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class ProductServiceImpl<D> implements ProductService {
	@Autowired
	private MapperFacade formDomainMapperFacade;
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductForm saveProduct(ProductForm productForm) {
		Product product = formDomainMapperFacade.map(productForm, Product.class);
		populateFormToModelConverter(productForm, product);
		Product productSaved=productRepository.save(product);
		ProductForm form=formDomainMapperFacade.map(productSaved, ProductForm.class);
		return form;
	}

	private void populateFormToModelConverter(ProductForm productForm, Product product) {
		if (productForm.getFeatursList() != null) {
			for (FeaturesForm featuresForm : productForm.getFeatursList()) {
				Features features = formDomainMapperFacade.map(featuresForm, Features.class);
				product.addFeature(features);
			}
		}
		if(productForm.getRankingList() !=null) {
			for(RankingForm rankingForm:productForm.getRankingList()) {
				Ranking ranking=formDomainMapperFacade.map(rankingForm, Ranking.class);
				product.addRankin(ranking);
			}
		}

	}

	
	@Override
	public List<Product> products() {

		return productRepository.findAll();
	}

	@Override
	public ProductForm product(Integer productId) {
		ProductForm productForm = null;
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			productForm = formDomainMapperFacade.map(product, ProductForm.class);
		}
		RankingResponse rankingResponse=getRankingResponse(productForm.getRankingList()) ;
		productForm.setRankingResponse(rankingResponse);
		return productForm;
	}
public RankingResponse getRankingResponse(List<RankingForm> rankingForms) {
	int voteCount=0;
	int votesCasted=0;
	int percentage=0;
	if(rankingForms !=null && rankingForms.size()>0) {
		for (RankingForm rankingForm : rankingForms) {
			voteCount=voteCount+1;
			votesCasted+=rankingForm.getRanking();
		}
	}
	RankingResponse response=new RankingResponse();
	response.setTotalNumberOfvotes(voteCount);
	response.setProductRank(votesCasted);

	percentage=(votesCasted/(voteCount*8))*100;
	response.setPercentage(percentage);
	return response;
}
}
