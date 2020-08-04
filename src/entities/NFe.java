package entities;

public class NFe {
	
	private String number;
	private String series;
	private String date;
	private String description;
	
	
	public NFe(String number, String series, String date, String description) {
		this.number = number;
		this.series = series;
		this.date = date;
		this.description = description;
	}


	public String getNumber() {
		return number;
	}


	public String getSeries() {
		return series;
	}


	public String getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NFe other = (NFe) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "NFe [number=" + number + ", series=" + series + ", date=" + date + ", description=" + description + "]";
	}

}
