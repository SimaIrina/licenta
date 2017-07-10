package mum.waa.fd.app.repository;

import mum.waa.fd.app.domain.User;


public interface UserRepositoryCustom {

	/**
	 * Find an user with user's email and password
	 *
	 * @param email
	 *            to be found (aka username)
	 * @param password
	 *            password to be found
	 * @return {@link mum.waa.fd.app.domain.User}
	 */
	User findUserByEmailAndPassword(String email, String password);
}
