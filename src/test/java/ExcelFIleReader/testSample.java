package ExcelFIleReader;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {

			DataDriven data = new DataDriven();
			ArrayList<?> Array = data.getData("Add Profile");
			
			System.out.println(Array.get(0));
			System.out.println(Array.get(1));
			System.out.println(Array.get(2));
			System.out.println(Array.get(3));
			System.out.println(Array.get(4));
	}
}
