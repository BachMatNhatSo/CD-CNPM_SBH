package demohello.Service.User;

import org.springframework.stereotype.Service;

import demohello.Entity.Users;

@Service
public interface IAccountService {

	public int 	AddAccount(Users user);
	public boolean 	CheckAccount(Users user);
}
