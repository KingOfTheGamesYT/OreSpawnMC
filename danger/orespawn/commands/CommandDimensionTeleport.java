/*    */ package danger.orespawn.commands;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import danger.orespawn.util.Teleport;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.TextComponentString;
/*    */ import net.minecraft.util.text.TextFormatting;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandDimensionTeleport
/*    */   extends CommandBase
/*    */ {
/* 21 */   private final List<String> aliases = Lists.newArrayList((Object[])new String[] { "orespawn", "tpdim", "dimtp" });
/*    */   
/*    */   public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
/*    */     int dim;
/* 25 */     if (args.length < 1) {
/*    */       return;
/*    */     }
/*    */     try {
/* 29 */       dim = Integer.parseInt(args[0]);
/*    */     }
/* 31 */     catch (NumberFormatException e) {
/* 32 */       sender.sendMessage((ITextComponent)new TextComponentString(TextFormatting.RED + "Dimension ID Invalid"));
/*    */       return;
/*    */     } 
/* 35 */     if (sender instanceof EntityPlayer) {
/*    */       
/* 37 */       BlockPos senderPos = sender.getPosition();
/* 38 */       Teleport.teleportToDimension((EntityPlayer)sender, dim, senderPos.getX(), senderPos.getY(), senderPos.getZ());
/* 39 */       EntityPlayer player = (EntityPlayer)sender;
/* 40 */       player.dimension = dim;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getAliases() {
/* 46 */     return this.aliases;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 52 */     return "dimensiontp";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage(ICommandSender arg0) {
/* 57 */     return "tpdimension <id>";
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\commands\CommandDimensionTeleport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */