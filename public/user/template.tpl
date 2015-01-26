<script type="text/ng-template" id="user_template.html">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" ng-click="cancel()"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">User Manipulation</h4>
    </div>
    <div class="modal-body">
        <form name="orderNow" action="#" method="POST">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">ID</span>
                                    <input type="text" ng-model="user.name" placeholder="Name"
                                           typeahead="item.name for item in userList | filter:$viewValue | limitTo:8"
                                           id="user.name" class="form-control" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">ID</span>
                                    <input type="text" ng-model="user.email" placeholder="Email "
                                           id="user.email" class="form-control" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <input class="form-control" ng-model="user.firstName"
                                       id="user.firstName" type="text" placeholder="First Name" required="true">
                            </div>
                            <div class="col-xs-6">
                                <input class="form-control" ng-model="user.lastName"
                                       id="user.lastName" type="text" placeholder="Last Name" required="true">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">$</span>
                                    <input class="form-control" ng-model="menuItem.regularPrice"
                                           id="menuItem.regularPrice" type="number" placeholder="Regular Price" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">$</span>
                                    <input class="form-control" ng-model="menuItem.addOnPrice"
                                           id="menuItem.addOnPrice" type="number" placeholder="Add On Price" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">$</span>
                                    <input class="form-control" ng-model="menuItem.discountPrice"
                                           id="menuItem.discountPrice" type="number" placeholder="Discount Price" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <textarea class="form-control" ng-model="user.description"
                                       id="user.description" placeholder="Description"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">ID</span>
                                    <input class="form-control" ng-model="user.userName"
                                       id="user.userName" type="text" placeholder="Login Name" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <span class="input-group-addon" id="sizing-addon2">***</span>
                                    <input class="form-control" ng-model="user.password"
                                       id="user.password" type="text" placeholder="Login Password" required="true" aria-describedby="sizing-addon2">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table class="table table-condensed" style="width: 100%">
                                    <thead>
                                    <tr><th colspan="3">
                                            <div class="col-xs-12">
                                                <div class="input-group">
                                                    <input type="text" ng-model="thisGroup" placeholder="User Roles"
                                                           typeahead="item as item.name for item in userRoles | filter:$viewValue | limitTo:8"
                                                           id="user.roles" class="form-control" required="true" aria-describedby="sizing-addon2">
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-primary" type="button" ng-click="addThis()">
                                                            <i class="fa fa-plus"></i>
                                                        </button>
                                                    </span>
                                                </div>
                                            </div>
                                        </th></tr>
                                        <tr><th>Modifier Name</th><th>Type</th><th>Action</th></tr>
                                    </thead>
                                    <tbody>
                                        <tr ng-repeat="doc in user.roles">
                                            <td>{{doc.name}}</td><td>{{doc.value}}</td><td> <i class="fa fa-trash-o fa-fw fa-2x" ng-click="removeThis(doc)"></i></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">Cancel</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="addNow()">Add Now</button>
    </div>

</script>
<!--
<button class="btn btn-default" ng-click="open()">Open me!</button>
<button class="btn btn-default" ng-click="open('lg')">Large modal</button>
<button class="btn btn-default" ng-click="open('sm')">Small modal</button>
-->
