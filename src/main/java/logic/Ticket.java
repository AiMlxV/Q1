package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
		switch (type) {
			case 0:
				this.type = 0;	// Student
				this.priceperstation = 30;
				break;
			case 1:
				this.type = 1;	// Adult
				this.priceperstation = 30;
				break;
			case 2:
				this.type = 2;	// Elderly
				this.priceperstation = 25;
				break;
			default:
				this.type = 1;	// Invalid -> Set to Adult by Default
				this.priceperstation = 30;
				break;
		}
	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
		if (isStationValid(start, end)) {
			int distance = getStationDistance(start, end);
			double discountRate = 1;	// 1 meaning no discount
			if (type == 0) {
				if (distance > 4){
					discountRate = 0.8;
				}
			}
			else if (type == 2) {
				discountRate = 0.6;
			}
			return (distance*priceperstation)*discountRate;
		} else {
			return -1;	// Invalid ticket
		}

	}
	
	public String getDescription() {
		String typename = "Invalid";

		if (isStationValid(start, end)) {
            typename = switch (type) {
                case 0 -> "Student";
                case 1 -> "Adult";		//FILL CODE
                case 2 -> "Elderly";	//FILL CODE
                default -> "Invalid";
            };

		}
		return typename + " Ticket, from " + this.start.getName() + " to " + this.end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
