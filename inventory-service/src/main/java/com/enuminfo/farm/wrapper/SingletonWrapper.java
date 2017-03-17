/**
 * 
 */
package com.enuminfo.farm.wrapper;

/**
 * @author Kumar
 */
class SingletonWrapper {

	static final CategoryWrapper CATEGORY_WRAPPER_INSTANCE = new CategoryWrapper();
	static final ProductWrapper PRODUCT_WRAPPER_INSTANCE = new ProductWrapper();
	static final CatalogWrapper CATALOG_WRAPPER_INSTANCE = new CatalogWrapper();
	static final CatalogProductWrapper CATALOG_PRODUCT_WRAPPER_INSTANCE = new CatalogProductWrapper();
}
