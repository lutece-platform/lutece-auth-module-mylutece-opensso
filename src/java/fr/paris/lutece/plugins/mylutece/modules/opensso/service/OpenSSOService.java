package fr.paris.lutece.plugins.mylutece.modules.opensso.service;

import fr.paris.lutece.plugins.mylutece.authentication.MultiLuteceAuthentication;
import fr.paris.lutece.plugins.mylutece.modules.opensso.authentication.OpenSSOAuthentication;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.service.util.AppLogService;

public final class OpenSSOService
{
	private static final String AUTHENTICATION_BEAN_NAME = "mylutece-opensso.authentication";

	private static OpenSSOService _instance = new OpenSSOService();
	/**
	 * Empty constructor
	 */
	private OpenSSOService()
	{
		// nothing
	}
	
	public static OpenSSOService getInstance(  )
	{
		return _instance;
	}
	
	public void init(  )
	{
		OpenSSOAuthentication authentication = ( OpenSSOAuthentication ) SpringContextService.getPluginBean( OpenSSOPlugin.PLUGIN_NAME, 
				AUTHENTICATION_BEAN_NAME );
		if ( authentication != null )
		{
			MultiLuteceAuthentication.registerAuthentication( authentication );
		}
		else
		{
			AppLogService.error( "OpenSSOAuthentication not found, please check your mylutece-opensso.xml configuration" );
		}
	}
}
