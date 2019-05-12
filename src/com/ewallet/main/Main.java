package com.ewallet.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ewallet.entity.AccountEntity;
import com.ewallet.entity.CustomerEntity;
import com.ewallet.entity.TransactionEntity;
import com.ewallet.entity.WalletEntity;
import com.ewallet.implement.AccountImpl;
import com.ewallet.implement.CustomerImpl;
import com.ewallet.implement.TransactionImpl;
import com.ewallet.implement.WalletImpl;
import com.ewallet.interfaces.AccountInterface;
import com.ewallet.interfaces.CustomerInterface;
import com.ewallet.interfaces.TransactionInterface;
import com.ewallet.interfaces.WalletInterface;

public class Main {
	// obj input etc.
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	static BufferedReader input = new BufferedReader(inputStreamReader);
	// customer
	private static CustomerEntity customer = new CustomerEntity();
	private static CustomerInterface icustomer = new CustomerImpl();
	private static CustomerImpl customerimpl = new CustomerImpl();
	//account
	private static AccountEntity account = new AccountEntity();
	private static AccountInterface iaccount = new AccountImpl();
	private static AccountImpl accountimpl = new AccountImpl();
	//wallet
	private static WalletEntity wallet = new WalletEntity();
	private static WalletInterface iwallet = new WalletImpl();
	private static WalletImpl walletimpl = new WalletImpl();
	
	//Transaction
	private static TransactionEntity transaction = new TransactionEntity();
	private static TransactionInterface itransaction = new TransactionImpl();
	private static TransactionImpl transactionimpl = new TransactionImpl();
	
	public static void main(String[] args) {
		menuUtama();
	}

	private static void menuUtama() {
		System.out.println("\n");
		System.out.println("\t\t Menu Utama");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. Registration");
		System.out.println("2. Add Wallet");
		System.out.println("3. Transaction");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				menuRegist();
				break;
			}
			case 2: {
				wallet();
				break;
			}
			case 3: {
				//tranSaction();
				menuTransaction();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				menuUtama();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("This field can't empty!");
			menuUtama();
		}
	}

	
	private static void menuTransaction() {
		System.out.println("\n");
		System.out.println("\t\t Registration");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. Top Up");
		System.out.println("2. Transafer");
		System.out.println("3. Tarik Tunai");
		System.out.println("4. Back");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3][4] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				getDebit();
				break;
			}
			case 2: {
				getCredit();
				break;
			}
			case 3: {
				getCredit();
				break;
			}
			case 4: {
				menuUtama();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				menuRegist();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("This field can't empty!");
			menuTransaction();
		}
	}

	private static void getDebit() {
		try {
			System.out.println();
			System.out.println("=============================== Debit =============================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Account Number  : ");
			int acnum = Integer.parseInt(input.readLine());
			System.out.print("Amount : ");
			int amount = Integer.parseInt(input.readLine());
			System.out.print("Transaction Type   : ");
			int type = Integer.parseInt(input.readLine());
			
			TransactionEntity trans = new TransactionEntity();
			trans.setDate(currentDate());
			trans.setAccount_number(acnum);
			trans.setAmount(amount);
			trans.setTransaction_typeTr(type);
			
			transactionimpl.addDebit(trans);;
			//showmenu
			menuTransaction();


		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuTransaction();
			
		}
	}
	
	private static void getCredit() {
		try {
			System.out.println();
			System.out.println("=============================== Credit ============================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Account Number  : ");
			int acnum = Integer.parseInt(input.readLine());
			System.out.print("Amount : ");
			int amount = Integer.parseInt(input.readLine());
			System.out.print("Transaction Type   : ");
			int type = Integer.parseInt(input.readLine());
			
			TransactionEntity trans = new TransactionEntity();
			trans.setDate(currentDate());
			trans.setAccount_number(acnum);
			trans.setAmount(amount);
			trans.setTransaction_typeTr(type);
			
			transactionimpl.addCredit(trans);;
			//showmenu
			menuTransaction();


		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuTransaction();
			
		}
	}

	private static void menuRegist() {
		System.out.println("\n");
		System.out.println("\t\t Registration");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. New");
		System.out.println("2. List of Customers");
		System.out.println("3. List of Customers Account");
		System.out.println("4. Search");
		System.out.println("5. Back");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3][4] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				addCustomer();
				break;
			}
			case 2: {
				getAllCustomer(customerimpl.getAllCustomer());
				break;
			}
			case 3: {
				getAllAccount(accountimpl.getAllAccount());
				break;
			}
			case 4: {
				searchCustomerById();
				break;
			}
			case 5: {
				menuUtama();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				menuRegist();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("This field can't empty!");
			menuRegist();
		}
	}
	
	private static void wallet() {
		try {
			System.out.println();
			System.out.println("============================= Add Wallet ==========================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Wallet ID.    : ");
			int idWallet = Integer.parseInt(input.readLine());
			System.out.print("Account Number: ");
			int accountNumber = Integer.parseInt(input.readLine());
			
			WalletEntity wallet = new WalletEntity();
			wallet.setId_wallet(idWallet);
			wallet.setAccount_number(accountNumber);
			
			walletimpl.addWalletAccount(wallet);
			addWallet(idWallet);
			//showmenu
			menuUtama();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuUtama();
			
		}
	}

	private static void addWallet(int idWallet) {
		try {
			System.out.print("Description   : ");
			String description = input.readLine();
			
			WalletEntity wallet = new WalletEntity();
			wallet.setDescription(description);
			wallet.setCreated_date(currentDate());
			
			walletimpl.addWallet(wallet, idWallet);
			// showMenu
			menuUtama();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuUtama();
		}
	}

	private static void getAllAccount(List<AccountEntity> account) {
		try {
			System.out.println("\n");
			System.out.println("==================== List of Customers Account =================");
			System.out.println("________________________________________________________________");
			// Print Header Table
			System.out.println("| " + padRight("No", 3) + "| " + padRight("Account No.", 15) + "| "
					+ padRight("Name", 25) + "|" + padRight("Balance", 14) + "|");
			System.out.println("----------------------------------------------------------------");
			int i = 1;
			// looping
			for (AccountEntity row : account) {
				System.out.println("| " + padRight("" + i, 3) + "| " + padRight("" + row.getAccount_number(), 15)
						+ "| " + padRight("" + row.getAccount_name(), 25) + "|" + padRight("Rp. " + row.getBalance(), 14)
						+ "|");

				// next row number
				i += 1;
			}
			System.out.println("________________________________________________________________");
			System.out.println("Successfully loaded!");
			menuRegist();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("Not found!");
			menuRegist();
		}
	}
	
	private static void addAccount(int cusnum) {
		try {
			System.out.println();
			System.out.println("============================ Add Account ==========================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Account No.    : ");
			int accountNo = Integer.parseInt(input.readLine());
			System.out.print("Account Name   : ");
			String accountName = input.readLine();
			//System.out.print("Open Date      : ");
			//String opened = input.readLine();
			System.out.print("Balance        : ");
			int balance = Integer.parseInt(input.readLine());
			//System.out.print("Customer No.   : ");
			//int customerNo = Integer.parseInt(input.readLine());
			
			AccountEntity account = new AccountEntity();
			account.setAccount_number(accountNo);
			account.setAccount_name(accountName);
			account.setOpen_date(currentDate());
			account.setBalance(balance);
			//account.setCustomer_number(cusnum);
			accountimpl.addAccount(account, cusnum);
			// showMenu
			
			menuRegist();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuRegist();
		}
	}

	//==========================================================================================//
	private static void addCustomer() {
		System.out.println("\n");
		try {
			//random
			int number = new Random().nextInt(900000)+1000000;
			int cusnum = Integer.valueOf(number);
			System.out.println("=================== Form Registrasi Customer ======================");
			System.out.println("___________________________________________________________________");
			System.out.println();
//			System.out.print("No. Customer   : ");
//			int cusnum = Integer.parseInt(input.readLine());
			System.out.print("Firstname      : ");
			String fname = input.readLine();
			System.out.print("Lastname       : ");
			String lname = input.readLine();
			System.out.print("Birtdate       : ");
			String birthdate = input.readLine();

			CustomerEntity customer = new CustomerEntity();
			customer.setCustomer_number(cusnum);
			customer.setFirstname(fname);
			customer.setLastname(lname);
			customer.setBirthdate(birthdate);
			//add customer
			customerimpl.addCustomer(customer);
			//add account by parameter
			addAccount(cusnum);

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			menuRegist();
		}

	}

	private static void getAllCustomer(List<CustomerEntity> customer) {
		try {
			System.out.println("\n");
			System.out.println("======================= List of Customers ======================");
			System.out.println("________________________________________________________________");
			// Print Header Table
			System.out.println("| " + padRight("No", 3) + "| " + padRight("Customer No.", 15) + "| "
					+ padRight("Name", 25) + "|" + padRight("Birthdate", 14) + "|");
			System.out.println("----------------------------------------------------------------");
			int i = 1;
			// looping
			for (CustomerEntity row : customer) {
				System.out.println("| " + padRight("" + i, 3) + "| " + padRight("" + row.getCustomer_number(), 15)
						+ "| " + padRight("" + row.getFullName(), 25) + "|" + padRight("" + row.getBirthdate(), 14)
						+ "|");

				// next row number
				i += 1;
			}
			System.out.println("________________________________________________________________");
			System.out.println("Successfully loaded!");
			menuRegist();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("Not found!");
			menuRegist();
		}
	}

	private static void searchCustomerById() {
		try {
			System.out.println();
			System.out.println("======================= Search Customer ID ========================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Customer ID : ");
			int id = Integer.parseInt(input.readLine());
		    customer = customerimpl.getById(id);
		    printResult(customer);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.print("Not found!");
			menuRegist();
		}
	}
	
	private static void printResult(CustomerEntity customer) {
		System.out.println("\n");
		System.out.println("Result : ");
		// Print Header Table
		System.out.println("| " + padRight("No", 3) + "| " + padRight("Customer No.", 15) + "| "
				+ padRight("Name", 25) + "|" + padRight("Birthdate", 14) + "|");
		System.out.println("----------------------------------------------------------------");
		//show data
		System.out.println("| " + padRight("1", 3) + "| " + padRight(""+customer.getCustomer_number(), 15) + "| "
				+ padRight(customer.getFullName(), 25) + "|" + padRight(customer.getBirthdate(), 14) + "|");
		menuRegist();
	}	

	private static String currentDate() {
		Date noww = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		return formatDate.format(noww);
	}
	
	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);
	}
}
