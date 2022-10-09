package com.example.demo.api;

import com.example.demo.dto.BaseDto;
import com.google.gson.Gson;

import java.io.IOException;

public class GsonApi {

    //싱글톤

    public BaseDto parse (int start, int end) throws IOException {
        Gson gson = new Gson();
        BaseDto baseDto;
        String jsonData = JsonData.run(start, end);
        baseDto = gson.fromJson(jsonData, BaseDto.class);
        return baseDto;

    }
}
