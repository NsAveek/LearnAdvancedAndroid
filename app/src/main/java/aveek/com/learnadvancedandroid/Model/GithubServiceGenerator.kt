package aveek.com.learnadvancedandroid.Model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GithubServiceGenerator {

    companion object {

        lateinit var gitHubService: GitHubService

        fun gitHubServiceMethod(baseUrl: String): GitHubService {

            if (gitHubService == null) {
                val httpLoginInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClient : OkHttpClient = OkHttpClient().newBuilder()
                        .addInterceptor(httpLoginInterceptor)
                        .readTimeout(5,TimeUnit.MINUTES)
                        .connectTimeout(5,TimeUnit.MINUTES).build()
                val retrofit : Retrofit = Retrofit.Builder().baseUrl(baseUrl)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient).build()

                gitHubService = retrofit.create(GitHubService::class.java)

            }
            return gitHubService
        }
    }
}