package tn.esprit.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailFournisseur {
	   private String name;

	    private String productName;

	    private String description;

	    private String email;

		@Override
		public String toString() {
			return "MailFournisseur [name=" + name + ", productName=" + productName + ", description=" + description
					+ ", email=" + email + "]";
		}
	    
}
