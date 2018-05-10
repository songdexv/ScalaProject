package chapter8

/**
  * Created by songdexv on 2018/5/7.
  */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var freeNum: Int = _

  def earnMonthlyInterest(interest: Double): Unit = {
    freeNum = 3
    super.deposit(interest)
  }

  override def deposit(amount: Double): Double = {
    freeNum -= 1
    if (freeNum < 0) super.deposit(amount - 1) else super.deposit(amount)
  }

  override def withdraw(amount: Double): Double = {
    freeNum -= 1
    if (freeNum < 0) super.withdraw(amount + 1) else super.withdraw(amount)
  }
}
