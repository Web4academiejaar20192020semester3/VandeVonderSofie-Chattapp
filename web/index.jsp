<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body onload="getFriends(); openSocket(); getMessage();">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>


<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:choose>


    <c:when test="${user!=null}">
        <form style="float: right" method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
        <div class="inlineblock">
            <p>Welcome ${user.getFirstName()}!</p>
            <section class="opdracht">
                <h2>Your current status</h2>
                <p id="currentStatus">${user.getStatus()}</p>
            </section>

                <%--<section class="opdracht">
                    <p>Online: </p>
                    <div id="onlineDIV"></div>

                    <p>Offline: </p>
                    <div id="offlineDIV"></div>


                </section>--%>
                <%--        <section class="opdracht">
                            <button id="statsJQButton">Get stats with jQuery</button>
                            <button id="deleteStatsJQbutton">Delete stats</button>
                            <div id="hiddenDiv" style="display: none; margin-top: 1%;">

                                <div id="onlineDIVJQ"></div>
                                <div id="offlineDIVJQ"></div>

                            </div>


                        </section>--%>

            <section class="opdracht">
                <p style="margin-bottom: 2%">Change your status:</p>
                <label for="selectedStatus"></label><select id="selectedStatus">
                <option value="null"></option>
                <option value="Online">Online</option>
                <option value="Busy">Busy</option>
                <option value="Away">Away</option>
                <option value="Offline">Offline</option>
            </select>

                <input type="button" id="changeSelectedStatus" value="Change status"
                       onclick="changeSelectedStatus()">

                <label for="statusInput"></label><input id="statusInput" style="width: 100px">
                <input type="button" id="changeStatusButton" value="Change status" onclick="changeStatus()">

            </section>
            <section class="opdracht">
                <h2 style="margin-bottom: 3%">Your friends</h2>
                <table id="friendsTable">
                    <thead>
                    <tr>
                        <td style="font-weight:bold; color:mediumseagreen">Name</td>
                        <td style="font-weight:bold; color:mediumseagreen">Status</td>
                    </tr>
                    </thead>
                    <tbody id="friends"></tbody>
                </table>

            </section>

            <section class="opdracht">
                <button id="jQueryButton">Add a friend</button>
                <div id="hidden" style="display: none">
                    <label for="emailInput"></label><input type="text" name="emailFriend" value="email of existing user"
                                                           id="emailInput">
                    <input style="padding: 2%" type="button" onclick="addFriend();" value="Add friend">
                </div>
            </section>
        </div>

        <div class="inlineblock">

            <section class="opdracht">


                <h2>Chat</h2>

                <div id="chatBox"></div>
                <form method="post">
                    <p class="weneedsomemarginhere">To:</p>
                    <label for="receiver"></label><input class="weneedsomemarginhere" id="receiver">

                    <p class="weneedsomemarginhere">Message:</p>
                    <label for="messageContentInput"></label><input id="messageContentInput"
                                                                    class="weneedsomemarginhere"
                                                                    style="height: 50px; width: 300px;">
                    <input type="button" onclick="sendMessage()" value="Send" id="sendMessageButton">
                </form>

            </section>
        </div>


    </c:when>


    <c:otherwise>


    <div>


        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>


        <section class="opdracht">
            <h2>Blog</h2>

            <div class="blog">
                <h5>Post 1</h5>
                <p>My back hurts</p>
                <img style="width: 500px;height: auto;align-self: center" src="images/stressfree.png"/>
                <div style="margin:3%" id="post1"></div>


                <p>Email: </p>
                <p><input type="text" id="user1"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment1"></p>
                <p>Rating:
                <p><input type="number" id="rating1"></p>


                <p><input type="button" id="blog1Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(1)"></p>
            </div>

            <div class="blog">
                <h5>Post 2</h5>
                <p>Basically my web 4</p>
                <img style="width: 500px;height: auto" src="images/bugs.png">
                <div style="margin:3%" id="post2"></div>


                <p>Email: </p>
                <p><input type="text" id="user2"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment2"></p>
                <p>Rating:
                <p><input type="number" id="rating2"></p>
                <p><input type="button" id="blog2Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(2)"></p>


            </div>

            <div class="blog">
                <h5>Post 3</h5>
                <p>"We're not like other startups" - starter pack</p>
                <img src="images/starterpack.jpg"/>

                <div style="margin:3%" id="post3"></div>


                <p>Email: </p>
                <p><input type="text" id="user3"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment3"></p>
                <p>Rating:
                <p><input type="number" id="rating3"></p>
                <p><input type="button" id="blog3Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(3)"></p>

            </div>

            <div class="blog">
                <h5>Post 4</h5>
                <p>Collection of the essentials</p>
                <img style="width: 500px;height: auto" src="images/books.PNG">


                <div style="margin:3%" id="post4"></div>


                <p>Email: </p>
                <p><input type="text" id="user4"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment4"></p>
                <p>Rating:
                <p><input type="number" id="rating4"></p>
                <p><input type="button" id="blog4Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(4)"></p>

            </div>

            <div class="blog">
                <h5>Post 5</h5>
                <p>found some storage for my node_modules folder after running create-react-app</p>
                <img style="width: 500px;height: auto" src="images/node.jpg"/>

                <div style="margin:3%" id="post5"></div>

                <p>Email: </p>
                <p><input type="text" id="user5"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment5"></p>
                <p>Rating:
                <p><input type="number" id="rating5"></p>
                <p><input type="button" id="blog5Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(5)"></p>

            </div>

            <div class="blog">
                <h5>Post 6</h5>
                <p>My tears are permanent</p>
                <img src="images/cry.jpg"/>

                <div style="margin:3%" id="post6"></div>

                <p>Email: </p>
                <p><input type="text" id="user6"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment6"></p>
                <p>Rating:
                <p><input type="number" id="rating6"></p>
                <p><input type="button" id="blog6Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(6)"></p>

            </div>
            <div class="blog">
                <h5>Post 7</h5>
                <p>console.log("help");</p>

                <img src="images/noeyecontact.PNG"/>
                <div style="margin:3%" id="post7"></div>

                <p>Email: </p>
                <p><input type="text" id="user7"></p>
                <p>Comment:</p>
                <p><input type="text" id="comment7"></p>
                <p>Rating:
                <p><input type="number" id="rating7"></p>
                <p><input type="button" id="blog7Button" value="Post your comment"
                          onclick="addCommentForBlogNumber(7)"></p>

            </div>


        </section>
        <section class="opdracht">

            <p>Register new user:</p>

            <form action="Controller?action=AddNewUser" method="POST">

                <p><label>Firstname: </label>
                    <input type="text" id="firstNameOfNewUser" name="firstNameOfNewUser">
                </p>
                <p>
                    <label>Lastname: </label>
                    <input type="text" id="lastNameOfNewUser" name="lastNameOfNewUser">
                </p>

                <p>
                    <label>Email: </label>
                    <input type="text" id="emailOfNewUser" name="emailOfNewUser">

                <p id="role">
                    <label>Role: </label>

                    <select id="roleOfNewUser" name="roleOfNewUser">

                        <option value="LID">LID</option>
                        <option value="BIB">BIB</option>
                    </select>

                </p>

                <p id="genderP">
                    <label>Gender: </label>

                    <select id="genderOfNewUser" name="genderOfNewUser">

                        <option value="M">M</option>
                        <option value="F">F</option>
                    </select>

                </p>

                <p id="pw">
                    <label>Password: </label>
                    <label for="pwOfNewUser"></label><input type="text" id="pwOfNewUser" name="pwOfNewUser">
                </p>
                <p>
                    <label>Repeat password: </label>
                    <label for="pw2OfNewUser"></label><input type="text" id="pw2OfNewUser" name="pw2OfNewUser">

                </p>

                <p>
                    <label>Birth date: </label>

                <fieldset class="date">
                    <label for="day"></label><select id="day" name="day">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>

                </select>

                    <label for="month"></label><select id="month" name="month">
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>


                    <label for="year"></label><select id="year" name="year">
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="2000">2000</option>

                </select>
                </fieldset>


                <p><input type="submit" value="Register" id="registerbutton"></p>

            </form>


        </section>

        </c:otherwise>
        </c:choose>


</main>


<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/2_changestatus.js"></script>
<script src="js/3_getFriendsTable.js"></script>
<script src="js/4_addFriend.js"></script>
<script src="js/5_blogpost.js"></script>
<script src="js/6_jQueryEffects.js"></script>
<%--<script src="js/7_getStats.js"></script>
<script src="js/7_getStats_jQuery.js"></script>--%>
<script src="js/8_chatting_jQuery.js"></script>

</body>
</html>