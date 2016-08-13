//new ES6 trick where you can manually specify which values will automatically get prefixed
var { Router,
    Route,
    IndexRoute,
    IndexLink,
    Link } = ReactRouter;

//Куда вставлять отрендеренный компонент
var destination = document.querySelector("#container");

//Компонент-рамка с хедером
var App = React.createClass({
    render: function () {
        return (
            <div>
                <div className="latest-tweets-page">
                    <div className="row">
                        <div className="col-md-12">
                            <nav id="menu" className="navbar navbar-inverse">
                                <div className="container-fluid">
                                    <div className="navbar-header">
                                        <img src="/resources/images/logo.png" width="80 px" data-toggle="tooltip"
                                             title="Stwitter"/>
                                    </div>
                                    <ul className="nav navbar-nav">
                                        <li><IndexLink to="/" activeClassName="active">Home <span
                                            className="glyphicon glyphicon-home"></span></IndexLink></li>
                                        <li><Link to="/profile" activeClassName="active">My profile</Link></li>
                                        <li><Link to="/stwitts" activeClassName="active">My stwits</Link></li>
                                        <li><Link to="/friends" activeClassName="active">My firends</Link></li>
                                        <li><Link to="/search" activeClassName="active">Search <span
                                            className="glyphicon glyphicon-search"></span></Link></li>
                                    </ul>
                                    <ul className="nav navbar-nav navbar-right">
                                        <li><Link to="/registration" activeClassName="active"><span
                                            className="glyphicon glyphicon-user"></span> Register</Link></li>
                                        <li><Link to="/login" activeClassName="active"><span
                                            className="glyphicon glyphicon-log-in"></span> Login</Link></li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col-md-3">
                        </div>

                        <div id="main-content" className="col-md-6">
                            {this.props.children}
                        </div>

                        <div className="col-md-3">
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});


//Стартовая страница
var Home = React.createClass({

    componentDidMount: function () {
        var self = this;
        $.get("getLatestStwitts", function (data, status) {
            self.setState(data);
        });
    },

    render: function () {
        console.log(this.state);

        if (!this.state) {
            return <div></div>
        }

        var self = this;
        var elements = [];
        Object.keys(this.state).forEach(function (key) {
            elements.push(
                <div key={key}>
                    <div className="row stwitt-block">
                        <div className="avatar col-md-1">
                            <img src="/resources/images/avatar-temp.jpg" className="img-thumbnail" width="85"
                                 height="85"/>
                        </div>
                        <div className="stwitt-content col-md11">
                            <div className="author">
                                <a href="/temp.html">{self.state[key].authorLogin}</a>
                            </div>
                            <div className="stwitt-text">
                                <p>{self.state[key].content}</p>
                            </div>
                            <div className="stwitt-meta-info text-right">
                                <p><em>&rarr; Posted on {self.state[key].placeTime.date}
                                    at {self.state[key].placeTime.time}</em>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            );
        });

        return (
            <div>
                <h2>What people stwitted recently:</h2>
                {elements}
            </div>
        );
    }
});

//2я страница
var MyStwitts = React.createClass({
    render: function () {
        return (
            <div>
                <h2>GOT QUESTIONS?</h2>
                <p>The easiest thing to do is post on
                    our <a href="http://forum.kirupa.com">forums</a>.
                </p>
            </div>
        );
    }
});

//3я страница
var Profile = React.createClass({
    render: function () {
        return (
            <div>
                <h2>STUFF</h2>
                <p>Mauris sem velit, vehicula eget sodales vitae,
                    rhoncus eget sapien:</p>
                <ol>
                    <li>Nulla pulvinar diam</li>
                    <li>Facilisis bibendum</li>
                    <li>Vestibulum vulputate</li>
                    <li>Eget erat</li>
                    <li>Id porttitor</li>
                </ol>
            </div>
        );
    }
});

//Регистрация
var Register = React.createClass({
    render: function () {
        return (
            <div>
                <form id="registration-form" role="form" action="register" method="post" commandName="userForm">
                    <div className="form-group">
                        <label for="nickname">Nickname:</label>
                        <input type="text" className="form-control" path="nickName" id="nickName"/>
                    </div>
                    <div className="form-group">
                        <label for="email">Email address:</label>
                        <input type="email" className="form-control" path="email" id="email"/>
                    </div>
                    <div className="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" className="form-control" path="password" id="pwd"/>
                    </div>
                    <div className="form-group">
                        <label for="hobbies">Your hobby: </label>
                        <div id="hobbies" className="form-group">
                            <label className="checkbox-inline"><input type="checkbox" value="reading" path="hobby"/>Reading</label>
                            <label className="checkbox-inline"><input type="checkbox" value="tv"/>Watching TV</label>
                            <label className="checkbox-inline"><input type="checkbox" value="family-time"/>Family
                                Time</label>
                            <label className="checkbox-inline"><input type="checkbox" value="movies"/>Going to
                                Movies</label>
                            <label className="checkbox-inline"><input type="checkbox" value="fishing"/>Fishing</label>
                            <label className="checkbox-inline"><input type="checkbox" value="computer"/>Computer</label>
                            <label className="checkbox-inline"><input type="checkbox"
                                                                      value="gardening"/>Gardening</label>
                            <label className="checkbox-inline"><input type="checkbox" value="walking"/>Walking</label>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-default center-block">Submit</button>
                </form>
            </div>
        );
    }
});


//Отрисовать нужный компонент
ReactDOM.render(
    <Router>
        <Route path="/" component={App}>
            <IndexRoute component={Home}/>
            <Route path="profile" component={Profile}/>
            <Route path="stwitts" component={MyStwitts}/>
            <Route path="search" component={MyStwitts}/>
            <Route path="friends" component={MyStwitts}/>
            <Route path="registration" component={Register}/>
            <Route path="login" component={MyStwitts}/>
        </Route>
    </Router>,
    destination
);



