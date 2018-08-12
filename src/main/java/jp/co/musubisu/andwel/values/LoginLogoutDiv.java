package jp.co.musubisu.andwel.values;

public enum LoginLogoutDiv implements Values {

	LOGIN("1","ログイン"),
	LOGOUT("2","ログアウト")

	;


    private String value = null;
    private String text = null;


    private LoginLogoutDiv(final String value, final String text) {
    	this.value = value;
    	this.text = text;
    }

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getText() {
		return this.text;
	}

}
