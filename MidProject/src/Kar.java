import java.util.ArrayList;

public class Kar {
	public void cekGaji(ArrayList <Karyawan> list) {
			if (list.size()%3 ==1 && list.size()>3) {
				for (int i = 0; i < list.size()-1; i++) {
				double gaji = list.get(i).getGaji();
				list.get(i).setGaji(gaji + 10*gaji/100);
				System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan id "+ list.get(i).getId());
				}
			}
	}
	public void cekGaji2(ArrayList <Karyawan> list) {
			if (list.size()%3 ==1 && list.size()>3) {
				for (int i = 0; i < list.size()-1; i++) {
				double gaji = list.get(i).getGaji();
				list.get(i).setGaji(gaji + 7.5*gaji/100);
				System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id "+ list.get(i).getId());
				}
			}
	}
	
	public void cekGaji3(ArrayList <Karyawan> list) {
			if (list.size()%3 ==1 && list.size()>3) {
				for (int i = 0; i < list.size()-1; i++) {
				double gaji = list.get(i).getGaji();
				list.get(i).setGaji(gaji + 5*gaji/100);
				System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan id "+ list.get(i).getId());
				}
			}
		
	}

}
