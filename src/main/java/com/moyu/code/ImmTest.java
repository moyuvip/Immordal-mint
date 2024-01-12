package com.moyu.code;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.moyu.util.OkHttpUtil;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author : moyuvip666
 * @Since: 2024/1/12 9:20
 */
@Slf4j
@SpringBootTest
public class ImmTest {


    @Test
    public void test() {
        String a = "{\"point\":{\"id\":4,\"image\":\"/img/project/palindrome_sat.png\",\"point\":200},\"userId\":913}";
        String b = "{\"point\":{\"id\":7,\"image\":\"/img/project/pizza_sat.png\",\"point\":150},\"userId\":913}";
        String c = "{\"point\":{\"id\":15,\"image\":\"/img/project/wizards.png\",\"point\":105},\"userId\":913}";
        String d = "{\"point\":{\"id\":4,\"image\":\"/img/project/palindrome_sat.png\",\"point\":200},\"userId\":913}";
        List<String> list = CollUtil.newArrayList(a, b, c, d);
        while (true) {
            long randomLong = RandomUtil.randomLong(0, 300);
            try {
                Thread.sleep(randomLong);
            } catch (InterruptedException e) {
                return;
            }
            int i = RandomUtil.randomInt(0, list.size());
            String res = null;
            try {
                res = OkHttpUtil.httpPostJson("https://game.immordals.xyz/api/add-point", getHeader(), list.get(i));
            } catch (Exception e) {
                System.out.println("请求失败");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException f) {
                    return;
                }
                break;
            }
            System.out.println(res);
        }

    }



    public static HashMap<String, String> getHeader() {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Authority", "game.immordals.xyz");
        headerMap.put("Accept", "application/json, text/plain, */*");
        headerMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,ee;q=0.7");
        headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0IiwianRpIjoiODRhMmY2N2E5ZGJiMWM1NzhhNWRkM2MxMDAyNTVkMWM2ODlkM2RhNzUxNjE1ODFkY2UyNTg0YjM4ZmZiZjA1ZTAyZTQ0NmM2YjFkYjZjZGQiLCJpYXQiOjE3MDUwMjE4NzYuNDc0ODUzOTkyNDYyMTU4MjAzMTI1LCJuYmYiOjE3MDUwMjE4NzYuNDc0ODU4MDQ1NTc4MDAyOTI5Njg3NSwiZXhwIjoxNzM2MTI1ODc2LjQxNjEyMTAwNjAxMTk2Mjg5MDYyNSwic3ViIjoiOTEzIiwic2NvcGVzIjpbXX0.gpGIqUfv_FVHPyO2vjCYO0x0YCc5E-C6Z24Wh6R5TVNxTy8dglvKP8fm-B1sQO9z-sVjxmd_Gxybe82xOHva8sz8_lucMrovVGhdL9OrcC6StD9bw20X7PwwI1rzwARPHHPvyw3gTVrNekfC764dswq7eHkTgg7PpLK54yPuqkh_1wgA9gS-Go-LJcdD-rbW_lMDSuxNxI1ewkQr0um94a3iJTjEPOHXIA_H6FdbVzlF3MFVH3-NBpxoEaJx7zR_428b2IFbIi8fYJAq4AzOS-P-1BUluG2sWo0tRFtM82qg28glfUD8SbKal7vZxarC5f5JLHabCU8pYiCZC7vxQzO2eQccXOYWh15ZOH_gPNtnyiLFKUdhImhszyuCsKDbiYp2hRPgSzcDrOuMYU5y7xt8mnUDXM4le30VEapCkXOnrifT7qZR7VBYLwNsFKYJ8bxhLXxp6AAG59fuK-4i-cK5X1AitXLbX-95Uy09qNOyZ03Iyq6RJ6o44eGlyzcMWjeTdwMaMogqSXWjG8lJd564R2AMGkxEfTm74Z5qoPi2ujgPZSc7lpTpco0FZG3Ag-eFIdQAvyRcB4OyASPX7trmuPvkXZ1bh9fGK6KQkMqdfekPfBDFOQuowjkWiI38eImsvP_rPyvTFfHRW59innasKDyDE_PEwbGpgdfCiSE");
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Cookie", "输入你的cookie");
        headerMap.put("Origin", "https://game.immordals.xyz");
        headerMap.put("Referer", "https://game.immordals.xyz/");
        headerMap.put("Sec-Ch-Ua-Mobile", "?0");
        headerMap.put("Sec-Ch-Ua-Platform", "Windows");
        headerMap.put("Sec-Fetch-Dest", "empty");
        headerMap.put("Sec-Fetch-Mode", "cors");
        headerMap.put("Sec-Fetch-Site", "same-origin");
        headerMap.put("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        headerMap.put("X-headerMaped-With", "XMLHttpheaderMap");
        headerMap.put("X-Xsrf-Token",
                "eyJpdiI6IjZwWVBaOExvTmUrMk1NVXpYRTcvTVE9PSIsInZhbHVlIjoiekZMWWthdUdoM2p0cmdObFRwRHRVbDM1OHNKekZJNVZpSkdlRjBoeEhVbk5IdTB0c3U1WTFOMGZxNGN3Unl1UzY5M3JhaTRrZzhhYlVFTk1VZWtHRERCS3Q3SlQ0UmNrbm5rdjZIWEY5UWpMbXV3RGwrYjY1aklpN0M2MEcrcnMiLCJtYWMiOiI5MGFmMGRjZWRkMDY5OGNhOWIxMzBiNDNjN2JmZGQ0YjQ0NjUzMzdkZWMwNGUyNDgzZmIzZDViM2VkOGNmNTllIiwidGFnIjoiIn0=");
        return headerMap;
    }
}
