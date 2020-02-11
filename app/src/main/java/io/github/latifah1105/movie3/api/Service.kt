package io.github.latifah1105.movie3.api

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {

    private const val API_KEY = "a00ab13b6f84506870c3c5a1f7ae524e"
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private var retrofit: Retrofit? = null
    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor { chain ->
            var request: Request = chain.request()
            val url: HttpUrl = request.url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }
        .build()

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

}