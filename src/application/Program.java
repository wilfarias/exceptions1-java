package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = dateFormat.parse(scan.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = dateFormat.parse(scan.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation "+reservation);
			
			System.out.println("Enter date update reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = dateFormat.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = dateFormat.parse(scan.next());
			
			reservation.updateDate(checkIn, checkOut);
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reservation.updateDate(checkIn, checkOut);
				System.out.println("Reservation "+reservation);
			}
			
		}
		
		scan.close();
	}

}
