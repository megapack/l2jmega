package net.sf.l2j.gameserver.handler.itemhandlers;

import net.sf.l2j.gameserver.handler.IItemHandler;
import net.sf.l2j.gameserver.model.actor.Playable;
import net.sf.l2j.gameserver.model.actor.instance.Player;
import net.sf.l2j.gameserver.model.item.instance.ItemInstance;
import net.sf.l2j.gameserver.network.serverpackets.ActionFailed;
import net.sf.l2j.gameserver.network.serverpackets.NpcHtmlMessage;

public class SexCoin
  implements IItemHandler
{
  @Override
public void useItem(Playable playable, ItemInstance item, boolean forceUse)
  {
    if (!(playable instanceof Player)) {
      return;
    }
    Player activeChar = (Player)playable;

    activeChar.setSexChangeItemId(item.getItemId());
    
    NpcHtmlMessage html = new NpcHtmlMessage(0);
    html.setFile("data/html/mods/Coin Custom/SexChange.htm");
    activeChar.sendPacket(html);
    activeChar.sendPacket(ActionFailed.STATIC_PACKET);
  }
}
