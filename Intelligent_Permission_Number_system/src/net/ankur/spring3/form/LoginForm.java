package net.ankur.spring3.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
public class LoginForm {
        @NotEmpty
        @Size(min = 1, max = 50)
        private String userName;
        
        @NotEmpty
        @Size(min = 1, max = 20)
        private String password;
        
        private String notValid;
        
        public void setUserName(String userName) {
                this.userName = userName;
        }
        public String getUserName() {
                return userName;
        }
        public void setPassword(String password) {
                this.password = password;
        }
        public String getPassword() {
                return password;
        }
		public String getNotValid() {
			return notValid;
		}
		public void setNotValid(String notValid) {
			this.notValid = notValid;
		}
}