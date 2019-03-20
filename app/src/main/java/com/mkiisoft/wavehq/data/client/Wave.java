package com.mkiisoft.wavehq.data.client;

import com.mkiisoft.wavehq.data.model.Product;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface Wave {

    @GET("/businesses/{business_id}/products/")
    Observable<List<Product>> getProducts(@HeaderMap Map<String, String> headers, @Path("business_id") String businessId);
}