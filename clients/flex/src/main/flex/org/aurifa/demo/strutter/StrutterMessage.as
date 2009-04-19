package org.aurifa.demo.strutter {

    [Bindable]
    public class StrutterMessage {
        public var id:int;
        public var sent:Date;
        public var sentText:String;
        public var text:String;
        public var author:StrutterUser;

        public function StruttermEssage()
        {
        }
    }
}