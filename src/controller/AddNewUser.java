package controller;

import db.PersonRepositoryStub;
import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class AddNewUser extends SyncRequestHandler {

        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


                List<String> errors = new ArrayList<>();
                Person person = new Person();


                processNewUserID(person, request, errors);
                processNewUserFirstName(person, request, errors);
                processNewUserLastName(person, request, errors);
                processNewUserRole(person, request, errors);
                processNewUserPW(person, request, errors);
                processNewUserGender(person, request, errors);
                processNewUserAge(person, request, errors);

                PersonService service = getPersonService();

                if (errors.size() > 2) {
                        request.setAttribute("errors", errors);
                        System.out.println(errors.size());
                } else {
                        service.addPerson(person);
                        //System.out.println(service.getPersons());
                }

                return "index.jsp";
        }


        private void processNewUserID(Person person, HttpServletRequest request, List<String> errors) {

                 try {
                        String userID = request.getParameter("emailOfNewUser");
                        //System.out.println(userID);
                        person.setUserId(userID);
                } catch (Exception e) {
                        errors.add(e.getMessage());
                }
        }

        private void processNewUserFirstName(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String firstName = request.getParameter("firstNameOfNewUser");
                        // System.out.println(firstName);
                        person.setFirstName(firstName);
                } catch (Exception e) {
                        errors.add(e.getMessage());
                }
        }

        private void processNewUserLastName(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String lastName = request.getParameter("lastNameOfNewUser");
                        person.setLastName(lastName);
                } catch (Exception e) {
                        errors.add(e.getMessage());
                }


        }

        private void processNewUserPW(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String pw1 = request.getParameter("pwOfNewUser");
                        String pw2 = request.getParameter("pw2OfNewUser");
                        if (pw1.equals(pw2)) {
                                person.setHashedPassword(pw1);
                        } else {
                                errors.add("Password and repeated password don't match");
                        }

                } catch (Exception e) {
                        errors.add(e.getMessage());
                }
        }

        private void processNewUserRole(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String roleString = request.getParameter("role");
                        if (roleString.equals("BIB")) {
                                person.setRole(Role.BIB);
                        } else {
                                person.setRole(Role.LID);
                        }
                } catch (Exception e) {
                        errors.add("Choose a role");
                }
        }


        private void processNewUserGender(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String genderString = request.getParameter("gender");
                        char gender = genderString.charAt(0);
                        person.setGender(gender);
                } catch (Exception e) {
                        errors.add(e.getMessage());
                }

        }

        private void processNewUserAge(Person person, HttpServletRequest request, List<String> errors) {

                try {
                        String dayString = request.getParameter("day");
                        String monthString = request.getParameter("month");
                        String yearString = request.getParameter("year");

                        int day = Integer.parseInt(dayString);
                        int month = Integer.parseInt(monthString);
                        int yearOfBirth = Integer.parseInt(yearString);

                        LocalDate today = LocalDate.now();
                        LocalDate birthday = LocalDate.of(yearOfBirth, month, day);
                        Period currentAge = Period.between(birthday, today);

                        int age = currentAge.getYears();

                        person.setAge(age);

                } catch (Exception e) {
                        errors.add(e.getMessage());
                }
        }

}
