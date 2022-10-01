package com.example.demo.api;

import com.example.demo.api.Api;
import com.example.demo.dto.BaseDto;
import com.google.gson.Gson;

import java.io.IOException;

public class GsonApi {

    public BaseDto parse (int start, int end) throws IOException {
        Gson gson = new Gson();
        BaseDto baseDto;
        String data = Api.run(start, end);
        baseDto = gson.fromJson(data, BaseDto.class);
        return baseDto;
    }
}
