<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<header>
        <dl class="groupInfo headerInner">
            <dt>GOOGLE</dt>
            <dd>
                <img src="img/user.png" alt="">
                <span>최은서</span>님, 안녕하세요.
            </dd>
        </dl>
        <ul class="allInfo">
            <li><a href="todo.html" class="todoIcon">TO-DO</a></li>
            <li><a href="confirm.html" class="confirmIcon">CONFIRM</a></li>
            <li><a href="roadmap.html" class="roadMapIcon">ROADMAP</a></li>
        </ul>
        <dl class="headerInner">
            <dt>참여중인 프로젝트</dt>
            <dd class="projectSearch">
                <input type="text" placeholder="프로젝트명을 입력해주세요.">
                <input type="button" value="">
            </dd>
        </dl>
        <ul class="projectList">
            <li class="active">
                <a href="notice.html" class="projectTit">SAMSUNG 리뉴얼</a>
                <ul>
                    <li><a href="notice.html">TO-DO</a></li>
                    <li><a href="notice.html">NOTICE</a></li>
                </ul>
            </li>
            <li>
                <a href="notice.html" class="projectTit">LG 유지보수</a>
                <ul>
                    <li><a href="notice.html">TO-DO</a></li>
                    <li><a href="notice.html">NOTICE</a></li>
                </ul>
            </li>
        </ul>
    </header>