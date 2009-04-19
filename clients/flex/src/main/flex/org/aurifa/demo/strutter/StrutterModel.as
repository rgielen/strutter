package org.aurifa.demo.strutter{

    import mx.collections.ArrayCollection;

    [Bindable]
    public class StrutterModel {


        public static const MAX_CHARS:int = 140;

        public static const VIEW_NORMAL:int  = 0;
        public static const VIEW_LOGIN:int   = 1;
        public static const VIEW_PROFILE:int = 2;

        private static var _instance:StrutterModel = null;

        public var friends:ArrayCollection;
        public var posts:ArrayCollection;
        public var directs:ArrayCollection;

        public var user:StrutterUser;

        public var users:ArrayCollection;

        public var currentView:int = VIEW_NORMAL;

        public var message:String = "";

        public var info:String;

        public function StrutterModel() {


            // Test Data
/*
            var i:int;
            var item:StrutterMessage;
            var user:StrutterUser = new StrutterUser();
            user.alias = "john";
            user.realname = "John Who";
            user.shortBio = "bla";

            friends = new ArrayCollection();
            for ( i = 0; i < 200; i ++ )
            {
                item = new StrutterMessage();
                item.author = user;
                item.text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
                item.sent= new Date( );
                friends.addItem( item );
            }
            posts = new ArrayCollection();
            for ( i = 0; i < 200; i ++ )
            {
                item = new StrutterMessage();
                item.author = user;
                item.text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
                item.sent= new Date( );
                posts.addItem( item );
            }
            directs = new ArrayCollection();
            for ( i = 0; i < 200; i ++ )
            {
                item = new StrutterMessage();
                item.author = user;
                item.text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
                item.sent= new Date( );
                directs.addItem( item );
            }
*/
        }

        public static function get instance( ) : StrutterModel
        {
            if ( _instance == null )
                 _instance = new StrutterModel();

            return _instance;
        }

    }
}