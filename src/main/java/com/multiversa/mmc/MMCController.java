package com.multiversa.mmc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MMCController {

  @PostMapping("/mmc")
  public MMCResponse calcularMMC(@RequestBody MMCRequest request) {
    int num1 = request.getNum1();
    int num2 = request.getNum2();
    int mmc = calcularMMC(num1, num2);
    return new MMCResponse(mmc);
  }

  @GetMapping("/primo/{number}")
  public PrimoResponse verificarPrimo(@PathVariable int number) {
    boolean isPrime = isPrime(number);
    return new PrimoResponse(isPrime);
  }

  private int calcularMMC(int num1, int num2) {
    int mdc = 1;
    for (int i = 1; i <= Math.min(num1, num2); i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        mdc = i;
      }
    }
    return (num1 * num2) / mdc;
  }

  private boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

}
