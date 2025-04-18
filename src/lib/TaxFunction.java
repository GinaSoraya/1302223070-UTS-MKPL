package lib;

public class TaxFunction {
	Employee employee;
	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

    public static int calculateTax(Employee employee) {
		int tax = 0;
        int numberOfChildren = employee.getTotalChild();
		int numberOfMonthWorking = employee.getPeriod().getMonthWorkingInYear();
		int monthlySalary = employee.getSalary().getMonthlySalary();
		int otherMonthlyIncome = employee.getSalary().getOtherMonthlyIncome();
		int deductible = employee.getSalary().getAnnualDeductible();
        
        numberOfMonth(numberOfMonthWorking);
        
		if (numberOfChildren > 3) {
            numberOfChildren = 3;
		}
		
        int income = MonthlyIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible);
		if (employee.getSpouse() != null) {
            tax = income - (54000000 + 4500000 + (numberOfChildren * 1500000));
		}else {
            tax = income - 54000000;
		}
		
		if (tax < 0) {
            return 0;
		}
        return tax;
    }

	public static void numberOfMonth(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	public static int MonthlyIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible) {
		return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible));
	}
}
