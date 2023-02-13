import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
	Scanner scan = new Scanner(System.in);
	double gaji = 0;
	String nama,kelamin = "",jabatan = "";
	ArrayList<Karyawan> list = new ArrayList<>();
	ArrayList<Karyawan> bonus = new ArrayList<>();
	public void menu() {
		System.out.println("PT MEKSIKO");
		System.out.println("===========");
		System.out.println("1.Insert data Karyawan");
		System.out.println("2.view data Karyawan");
		System.out.println("3.update data Karyawan");
		System.out.println("4.delete data Karyawan");
		System.out.println("5.Exit");
		System.out.print(">>> ");
	}
	public String rand() {
		Random random = new Random();
		String str="";
		String word="QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i = 0; i < 7; i++) {
			if(i<=1) {
				str += word.charAt(random.nextInt(26));
			}else if(i==2) {
				str += "-";
			}else {
				str+= random.nextInt(10);
			}
			
		}
		return str;
	}
	
	
	public void insert() {
		String id = rand();
		do {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
		} while (nama.length()<3);
		do {
			System.out.print("Input jenis kelamin[Laki-laki | Perempuan]: ");
			kelamin = scan.nextLine();
		} while (!(kelamin.equals("Laki-laki")|| kelamin.equals("Perempuan")));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
			jabatan = scan.nextLine();
			if(jabatan.equals("Manager")) {
				gaji = 8000000;
			}else if(jabatan.equals("Supervisor")) {
				gaji = 6000000;
			}else {
				gaji = 4000000;
			}
		} while (!(jabatan.equals("Manager")|| jabatan.equals("Supervisor")|| jabatan.equals("Admin")));
		Karyawan wan = new Karyawan(nama, kelamin, jabatan, id, gaji);
		System.out.println("Berhasil menambahkan karyawan dengan id "+ wan.id);
		if (wan.getJabatan().equals("Manager")) {
			list.add(wan);
			Kar kar = new Kar();
			kar.cekGaji(list);
		}else if(wan.getJabatan().equals("Supervisor")){
			list.add(wan);
			Kar kar = new Kar();
			kar.cekGaji2(list);
		}else if(wan.getJabatan().equals("Admin")){
			list.add(wan);
			Kar kar = new Kar();
			kar.cekGaji3(list);
		}else {
			list.add(wan);
		}
		System.out.println("ENTER to return");
		scan.nextLine();
		

	}
	
	public void view() {
		if (list.isEmpty()) {
			System.out.println("Tidak ada data karyawan");
		}else {
			bubble();
			int ctr=1;
			System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
			System.out.printf("|%-3s |%-15s |%-20s |%-15s |%-10s |%-15s |\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan","Gaji karyawan");
			System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 

			for (Karyawan k : list) {
				System.out.printf("|%3s |%15s |%20s |%15s |%10s |%15s |\n", ctr, k.id, k.nama, k.kelamin, k.jabatan,String.format("%.0f", k.gaji));
				ctr ++;
			}
			}
			System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|");
			System.out.println("ENTER to return");
			scan.nextLine();

		}
	public void bubble() {
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = 0; j < list.size()-1 -i; j++) {
				if(list.get(j).nama.compareTo(list.get(j+1).nama)>0) {
					Karyawan temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
	public void update() {
		int updated = 0;
		String newnama,newkelamin,newjabatan = "";
		bubble();
		int ctr=1;
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		System.out.printf("|%-3s |%-15s |%-20s |%-15s |%-10s |%-15s |\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan","Gaji karyawan");
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		for (Karyawan k : list) {
			System.out.printf("|%3s |%15s |%20s |%15s |%10s |%15s |\n", ctr, k.id, k.nama, k.kelamin, k.jabatan,String.format("%.0f", k.gaji));
			ctr ++;
		}
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		System.out.print("Update Data [1 - "+list.size()+" ] [0 to cancel]:");
		updated = scan.nextInt();
		scan.nextLine();
		String id = rand();
		boolean run = true;
		if (updated ==0) {
			run = false;
		}else {
			do {
				System.out.print("Input nama urutan karyawan yang ingin diupdate[>=3]: ");
				newnama = scan.nextLine();
			} while (newnama.length()<3);
			do {
				System.out.print("Input jenis kelamin[Laki-laki | Perempuan]: ");
				newkelamin = scan.nextLine();
			} while (!(newkelamin.equals("Laki-laki")|| newkelamin.equals("Perempuan")));
			do {
				System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
				newjabatan = scan.nextLine();
				if(newjabatan.equals("Manager")) {
					gaji = 8000000;
				}else if(newjabatan.equals("Supervisor")) {
					gaji = 6000000;
				}else {
					gaji = 4000000;
				}
			} while (!(newjabatan.equals("Manager")|| newjabatan.equals("Supervisor")|| newjabatan.equals("Admin")));
			Karyawan ka = new Karyawan(newnama, newkelamin, newjabatan, id, gaji);
			list.set(updated-1, ka);
			System.out.println("Berhasil mengupdate karyawan dengan id "+ ka.id);
			System.out.println("ENTER to return");
			scan.nextLine();
		}
	}
	public void delete() {
		int deleted= 0;
		int ctr=1;
		boolean run = true;
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		System.out.printf("|%-3s |%-15s |%-20s |%-15s |%-10s |%-15s |\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan","Gaji karyawan");
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		for (Karyawan k : list) {
			System.out.printf("|%3s |%15s |%20s |%15s |%10s |%15s |\n", ctr, k.id, k.nama, k.kelamin, k.jabatan,String.format("%.0f", k.gaji));
			ctr ++;
		}
		System.out.println("|----|----------------|---------------------|----------------|-----------|----------------|"); 
		System.out.print("Input nomor urutan karyawan yang ingin dihapus [1 - "+list.size()+" ] [0 to cancel]: ");
		deleted = scan.nextInt();
		if (deleted ==0)  {
			run = false;
		}else {
			System.out.println("karyawan dengan id "+list.get(deleted-1).id+" berhasil dihapus");
			list.remove(deleted-1);
		}
		System.out.println("ENTER to return");
		scan.nextLine();
		
	}
		public Main() {
			int input =0;
		do {
			menu();
			input = scan.nextInt();
			scan.nextLine();
			switch (input) {
			case 1:
				insert();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Thank you for using this program ^-^");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		} while (input !=5);
	}
		public static void main(String[] args) {
		new Main();
		}
	}

