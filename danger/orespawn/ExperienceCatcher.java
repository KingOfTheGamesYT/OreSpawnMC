/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExperienceCatcher
/*     */   extends Item
/*     */ {
/*     */   public ExperienceCatcher(int i) {
/*  35 */     this.maxStackSize = 16;
/*  36 */     setCreativeTab(CreativeTabs.tabTools);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
/*  43 */     par2EntityPlayer.swingItem();
/*  44 */     System.out.printf("x, y,z, 7,8,9,10 == %d, %d, %d - %d, %f, %f, %f\n", new Object[] { Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(par7), Float.valueOf(par8), Float.valueOf(par9), Float.valueOf(par10) });
/*  45 */     if (!par2EntityPlayer.worldObj.isRemote) {
/*  46 */       AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(x - 0.5D + par8, y, z - 0.5D + par10, x + 0.5D + par8, y + 2.0D, z + 0.5D + par10);
/*  47 */       List var5 = world.getEntitiesWithinAABB(EntityXPOrb.class, bb);
/*  48 */       Iterator<Entity> var2 = var5.iterator();
/*  49 */       while (var2.hasNext()) {
/*     */         
/*  51 */         Entity var3 = var2.next();
/*  52 */         if (var3 instanceof EntityXPOrb) {
/*     */           
/*  54 */           EntityXPOrb ex = (EntityXPOrb)var3;
/*     */           
/*  56 */           if (ex.getXpValue() < 3 || world.rand.nextInt(5) == 1) {
/*     */             continue;
/*     */           }
/*  59 */           var3.setDead();
/*     */           
/*  61 */           EntityItem entityItem = null;
/*  62 */           ItemStack itemStack = new ItemStack(Items.experience_bottle, 1, 0);
/*  63 */           entityItem = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0D, (par10 + z), itemStack);
/*  64 */           if (entityItem != null) par2EntityPlayer.worldObj.spawnEntityInWorld((Entity)entityItem);
/*     */           
/*  66 */           itemStack = new ItemStack(Items.string, 1, 0);
/*  67 */           entityItem = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0D, (par10 + z), itemStack);
/*  68 */           if (entityItem != null) par2EntityPlayer.worldObj.spawnEntityInWorld((Entity)entityItem);
/*     */           
/*  70 */           itemStack = new ItemStack(Items.stick, 1, 0);
/*  71 */           entityItem = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0D, (par10 + z), itemStack);
/*  72 */           if (entityItem != null) par2EntityPlayer.worldObj.spawnEntityInWorld((Entity)entityItem);
/*     */           
/*  74 */           if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */           {
/*  76 */             par1ItemStack.stackSize--;
/*     */           }
/*  78 */           return true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  83 */       EntityItem var4 = null;
/*  84 */       ItemStack is = new ItemStack(OreSpawnMain.MyExperienceCatcher, 1, 0);
/*  85 */       var4 = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0D, (par10 + z), is);
/*  86 */       if (var4 != null) par2EntityPlayer.worldObj.spawnEntityInWorld((Entity)var4);
/*     */       
/*  88 */       par1ItemStack.stackSize--;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 100 */     par3EntityPlayer.swingItem();
/* 101 */     return par1ItemStack;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 106 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ExperienceCatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */