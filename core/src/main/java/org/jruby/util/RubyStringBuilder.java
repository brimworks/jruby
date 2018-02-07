package org.jruby.util;

import org.jruby.Ruby;
import org.jruby.RubyString;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * Helper methods to make Ruby Strings without the ceremony of manually building the string up.
  */
public class RubyStringBuilder {
    public static String buildString(Ruby runtime, IRubyObject value, String message) {
        RubyString buf = (RubyString) value.convertToString().dup();

        buf.cat19(runtime.newString(message));

        return buf.toString();
    }

    public static String buildString(Ruby runtime, String message, IRubyObject value) {
        RubyString buf = runtime.newString(message);

        buf.cat19(value.convertToString());

        return buf.toString();
    }

    public static String buildString(Ruby runtime, String messageBegin, IRubyObject value, String messageEnd) {
        RubyString buf = runtime.newString(messageBegin);

        buf.cat19(value.convertToString());
        buf.cat19(runtime.newString(messageEnd));

        return buf.toString();
    }

    public static String buildString(Ruby runtime, IRubyObject value, String message, IRubyObject value2) {
        RubyString buf = (RubyString) value.convertToString().dup();

        buf.cat19(runtime.newString(message));
        buf.cat19(value2.convertToString());

        return buf.toString();
    }

    public static String buildString(Ruby runtime, String messageBegin, IRubyObject value, String messageMiddle, IRubyObject value2) {
        RubyString buf = runtime.newString(messageBegin);

        buf.cat19(value.convertToString());
        buf.cat19(runtime.newString(messageMiddle));
        buf.cat19(value2.convertToString());

        return buf.toString();
    }
}