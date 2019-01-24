package com.task14.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DAOListExpenses {

  Receiver getReceiver(int num) throws ListExpensesException;

  ArrayList<Receiver> getReceivers(String query) throws ListExpensesException;

  ArrayList<Receiver> getReceivers() throws ListExpensesException;

  Expense getExpense(int num) throws ListExpensesException;

  ArrayList<Expense> getExpenses(String query) throws ListExpensesException;

  ArrayList<Expense> getExpenses() throws ListExpensesException;

  int addReceiver(Receiver receiver) throws ListExpensesException;

  int addExpense(Expense expense) throws ListExpensesException;

  ResultSet executeQueryAtListExpenses(String query) throws ListExpensesException;

  boolean executeUpdateAtListExpenses(String query) throws ListExpensesException;
}
