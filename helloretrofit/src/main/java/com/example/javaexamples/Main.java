package com.example.javaexamples;

import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.GsonConverterFactory;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;

import java.net.Proxy;

public class Main {

    public static class Repo {
        public final String name;

        public Repo(String s) {name = s;}
    }

    public interface GitHubService {
      @GET("/users/{user}/repos")
      Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public static void main(String[] args) {

        Common.init("Hello Retrofit");

        try {
            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("https://api.github.com")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

            GitHubService service = retrofit.create(GitHubService.class);

            Call<List<Repo> > call = service.listRepos("square");
        
            List<Repo> repos = call.execute().body();
            for (Repo r: repos) {
                System.out.println("Repo : " + r.name);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

