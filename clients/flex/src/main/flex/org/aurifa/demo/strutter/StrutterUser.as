package org.aurifa.demo.strutter {

import mx.collections.ArrayCollection;

    [Bindable]
    public class StrutterUser {

        public var icon:String = "user.jpg";
        public var alias:String;
        public var password:String = "dummy";
        public var realname:String;
        public var shortBio:String;
        public var messages:ArrayCollection;

        public function StrutterUser()
        {
        }
    }
}