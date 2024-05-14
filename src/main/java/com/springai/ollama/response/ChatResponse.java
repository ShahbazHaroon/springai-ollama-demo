/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
//With chainable setters, set the fields within the same line using method chaining, and the compiler will continue to process subsequent setter calls without the need for semicolons between them
//Example: Person person = new Person().setName("John").setAge(30);
//Without chainable setters, need to use a semicolon after each setter call, indicating the end of the statement. This ensures that each setter call is treated as a separate statement by the compiler
//Example: Person person = new Person(); person.setName("John"); person.setAge(30);
@Accessors(chain = true)
public class ChatResponse {

    private String message;
}