package mediacenter;

import java.util.*;

public class utilizador {

 
	private String username;
	private String password;
	private String email;
	private String profileName;
	private String avatar;
	private int numberFriends;
	private String memberSince;
        private Map<Integer,playlistsUser> pls;
        
        
        
        
        public utilizador (String username1, String password1, String email1, String profileName1, String avatar1, int numberFriends1, String memberSince1) {
            username = username1;
            password = password1;
            email = email1;
            profileName = profileName1;
            avatar = avatar1;
            numberFriends = numberFriends1;
            memberSince = memberSince1;
         
        }
        
        public utilizador (){
            username="";
            password = "";
            email = "";
            profileName = "";
            avatar = "";
            numberFriends = 0;
            memberSince = "";
            pls = new HashMap<>();
         
        }
        
	public String getUsername() {
		return this.username;
	}
        
        
        public Map<Integer,playlistsUser> getPlayLists() {
            return pls;
        }
        
        public void setPlayLists(HashMap<Integer,playlistsUser> pls1) {
            pls = pls1;
        }

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileName() {
		return this.profileName;
	}

	/**
	 * 
	 * @param profileName
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * 
	 * @param avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getNumberFriends() {
		return this.numberFriends;
	}

	/**
	 * 
	 * @param numberFriends
	 */
	public void setNumberFriends(int numberFriends) {
		this.numberFriends = numberFriends;
	}

	public String getMemberSince() {
		return this.memberSince;
	}

	/**
	 * 
	 * @param memberSince
	 */
	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

}