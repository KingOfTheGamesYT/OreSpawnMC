/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.EnumDifficulty;
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
/*     */ public class EntityRedAnt
/*     */   extends EntityAnt
/*     */ {
/*  32 */   int attack_delay = 20;
/*     */ 
/*     */   
/*     */   public EntityRedAnt(World par1World) {
/*  36 */     super(par1World);
/*     */     
/*  38 */     setSize(0.2F, 0.2F);
/*  39 */     this.moveSpeed = 0.20000000298023224D;
/*  40 */     this.experienceValue = 1;
/*  41 */     getNavigator().setAvoidsWater(true);
/*  42 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D));
/*  43 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.0D, false));
/*  44 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  45 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 4, true));
/*     */   
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  50 */     super.applyEntityAttributes();
/*  51 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  52 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  53 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  59 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  66 */     if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0) return false; 
/*  67 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false; 
/*  68 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0F);
/*  69 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  79 */     if (par1EntityPlayer == null) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     if (!(par1EntityPlayer instanceof EntityPlayerMP)) return false;
/*     */ 
/*     */     
/*  88 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*  89 */     if (var2 != null && 
/*  90 */       var2.stackSize <= 0) {
/*  91 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  92 */       var2 = null;
/*     */     } 
/*     */     
/*  95 */     if (var2 != null) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID2) {
/* 100 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID2, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(OreSpawnMain.DimensionID2), OreSpawnMain.DimensionID2, this.worldObj));
/*     */     } else {
/*     */       
/* 103 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(0), 0, this.worldObj));
/*     */     } 
/*     */ 
/*     */     
/* 107 */     return true;
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
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 121 */     super.onUpdate();
/* 122 */     if (this.isDead)
/* 123 */       return;  if (this.attack_delay > 0) this.attack_delay--; 
/* 124 */     if (this.attack_delay > 0)
/* 125 */       return;  this.attack_delay = 20;
/* 126 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
/* 127 */       return;  if (OreSpawnMain.PlayNicely != 0)
/* 128 */       return;  EntityPlayer entityPlayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 1.5D);
/* 129 */     if (entityPlayer != null)
/* 130 */       attackEntityAsMob((Entity)entityPlayer); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityRedAnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */