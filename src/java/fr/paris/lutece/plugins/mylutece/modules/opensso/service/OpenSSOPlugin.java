package fr.paris.lutece.plugins.mylutece.modules.opensso.service;

import fr.paris.lutece.portal.service.plugin.PluginDefaultImplementation;

public class OpenSSOPlugin extends PluginDefaultImplementation
{
	public static final String PLUGIN_NAME = "mylutece-opensso";
	
	/**
	 * 
	 *{@inheritDoc}
	 */
	@Override
	public void init()
	{
		super.init();
		OpenSSOService.getInstance().init();
	}
}
