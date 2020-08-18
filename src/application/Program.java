package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = dateFormat.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = dateFormat.parse(scan.next());		
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation "+reservation);
			
			System.out.println("Enter date update reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = dateFormat.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = dateFormat.parse(scan.next());
			
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation "+reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			e.getMessage();
		} catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		scan.close();
	}

}
