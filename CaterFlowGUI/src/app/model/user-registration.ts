import { UserRole } from "../components/shared/enums/user-role.enum";

export class UserRegistration{
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    roles: UserRole[];

    constructor(username: string, password: string, firstName: string, lastName: string, email: string, roles: UserRole[]) {
        this.username = username
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.roles = roles
    }
}