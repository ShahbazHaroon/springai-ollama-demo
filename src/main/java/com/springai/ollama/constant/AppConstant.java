/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
//The access parameter is set to AccessLevel.PRIVATE to ensure that the constructor is only accessible within the class itself
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConstant {

    public static final String REQUEST_MAPPING = "/api";
    public static final String INPUT_PARAMETER_VALIDATION = "Input parameters are required";

}
