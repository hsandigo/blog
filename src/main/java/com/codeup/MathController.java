package com.codeup;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by humbertosandigo on 1/4/17.
 */

@Controller
public class MathController {
    @RequestMapping(path = "/add/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numberOne, @PathVariable int numberTwo ) {
        return numberOne + "+" + numberTwo + "=" + (numberOne + numberTwo);
    }

    @RequestMapping(path = "/subtract/{numberTwo}/from/{numberOne}}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numberTwo, @PathVariable int numberOne ) {
        return numberTwo + "-" + numberOne + "=" + (numberTwo - numberOne);
    }

    @RequestMapping(path = "/multiply/{numberOne}/and/{numberTwo}}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo ) {
        return numberOne + "*" + numberTwo + "=" + (numberOne * numberTwo);
    }

    @RequestMapping(path = "/divide/{numberTwo}/by/{numberOne}}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int numberTwo, @PathVariable int numberOne ) {
        return numberTwo + "/" + numberOne + "=" + (numberTwo / numberOne);
    }
}
