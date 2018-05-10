package chapter8

/**
  * Created by songdexv on 2018/5/7.
  */
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount; balance
  }

  def withdraw(amount: Double) = {
    balance -= amount; balance
  }
}
