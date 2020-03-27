package principal;

public class Reserva {
	private int codigoReserva;
	private String nombreReserva;
	private String apellidosReserva;
	private String fechaEntrada;
	private String fechaSalida;
	private String tipoHabitacion;
	private String regimen;
	private String sexo;
	private String numeroCuenta;
	private String fechaCaducidad;
	private double precio;
	private int numeroNoches;

	public Reserva(int codigoReserva, String nombreReserva, String apellidosReserva, String fechaEntrada,
			String fechaSalida, String tipoHabitacion, String regimen, String sexo, String numeroCuenta,
			String fechaCaducidad, double precio, int numeroNoches) {
		this.codigoReserva = codigoReserva;
		this.nombreReserva = nombreReserva;
		this.apellidosReserva = apellidosReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.tipoHabitacion = tipoHabitacion;
		this.regimen = regimen;
		this.sexo = sexo;
		this.numeroCuenta = numeroCuenta;
		this.fechaCaducidad = fechaCaducidad;
		this.precio = precio;
		this.numeroNoches = numeroNoches;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public String getApellidosReserva() {
		return apellidosReserva;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public String getRegimen() {
		return regimen;
	}

	public String getSexo() {
		return sexo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumeroNoches() {
		return numeroNoches;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public void setApellidosReserva(String apellidosReserva) {
		this.apellidosReserva = apellidosReserva;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	@Override
	public String toString() {
		return codigoReserva + nombreReserva + apellidosReserva + fechaEntrada + fechaSalida + tipoHabitacion + regimen
				+ sexo + numeroCuenta + fechaCaducidad + precio + numeroNoches;
	}

}
