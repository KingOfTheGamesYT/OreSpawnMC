/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ public class EntityAnt
/*     */   extends EntityAnimal
/*     */ {
/*  29 */   public double moveSpeed = 0.15000000596046448D;
/*  30 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "ant.png");
/*  31 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "red_ant.png");
/*  32 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "rainbow_ant.png");
/*  33 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "unstableant.png");
/*  34 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "termite.png");
/*     */ 
/*     */   
/*     */   public EntityAnt(World par1World) {
/*  38 */     super(par1World);
/*  39 */     setSize(0.1F, 0.1F);
/*  40 */     this.experienceValue = 0;
/*  41 */     getNavigator().setAvoidsWater(true);
/*  42 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4D));
/*  43 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 9, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  48 */     super.applyEntityAttributes();
/*  49 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  50 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  51 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  52 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */   
/*     */   public ResourceLocation getTexture(EntityAnt a) {
/*  56 */     if (a instanceof EntityRedAnt) return texture2; 
/*  57 */     if (a instanceof EntityRainbowAnt) return texture3; 
/*  58 */     if (a instanceof EntityUnstableAnt) return texture4; 
/*  59 */     if (a instanceof Termite) return texture5; 
/*  60 */     return texture1;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  64 */     if (isNoDespawnRequired()) return false; 
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  73 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  74 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  83 */     if (par1EntityPlayer == null) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (!(par1EntityPlayer instanceof EntityPlayerMP)) return false;
/*     */ 
/*     */     
/*  92 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*  93 */     if (var2 != null && 
/*  94 */       var2.stackSize <= 0) {
/*  95 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  96 */       var2 = null;
/*     */     } 
/*     */     
/*  99 */     if (var2 != null) {
/* 100 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 104 */     if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID) {
/* 105 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(OreSpawnMain.DimensionID), OreSpawnMain.DimensionID, this.worldObj));
/*     */     } else {
/*     */       
/* 108 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(0), 0, this.worldObj));
/*     */     } 
/*     */ 
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 127 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 151 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 160 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void playStepSound(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 205 */     if (this.posY < 50.0D) return false; 
/* 206 */     if (findBuddies() > 4) return false; 
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 212 */     List var5 = this.worldObj.getEntitiesWithinAABB(EntityAnt.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 213 */     return var5.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAITick() {
/* 218 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 219 */     super.updateAITick();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityAnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */