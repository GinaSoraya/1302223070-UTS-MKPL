package lib;

public class Period {
    private int yearJoined;
    private int monthJoined;
    private int monthWorkingInYear;

    public int getMonthWorkingInYear() {
    //Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
	LocalDate date = LocalDate.now();
		
	if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
	}else {
            monthWorkingInYear = 12;
	}
        return monthWorkingInYear;
    }
}